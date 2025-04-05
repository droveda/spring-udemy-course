//Create a Context

import { createContext, useContext, useState } from "react";
import { apiClient } from "../api/ApiClient";
import { executeBasicAuthenticationService, executeJWTAuthenticationService } from "../api/AuthenticationApiService";

export const AuthContext = createContext();

export const useAuth = () => useContext(AuthContext)

//Share the created context with other components
export default function AuthProvider({ children }) {

    //Put some state in the context
    const [number, setNumber] = useState(10)
    const [isAuthenticated, setAuthenticated] = useState(false)
    const [userName, setUserName] = useState(null)
    const [token, setToken] = useState(null)

    // function login(username, password) {
    //     if ((username === 'in28minutes' && password === 'dummy') || (username === 'Mike' && password === 'dummy')) {
    //         setAuthenticated(true)
    //         setUserName(username)
    //         return true
    //     } else {
    //         setAuthenticated(false)
    //         setUserName(null)
    //         return false
    //     }
    // }

    async function loginWithBasicAuth(username, password) {
        const basicAuthToken = 'Basic ' + window.btoa(username + ':' + password)

        try {
            const response = await executeBasicAuthenticationService(basicAuthToken)

            if (response.status == 200) {
                setAuthenticated(true)
                setUserName(username)
                setToken(basicAuthToken)

                apiClient.interceptors.request.use(
                    (config) => {
                        console.log('Adding a token')
                        if (basicAuthToken) {
                            config.headers.Authorization = basicAuthToken
                        }
                        return config
                    }
                )

                return true
            } else {
                logout()
                return false
            }
        } catch (error) {
            console.log(error)
            logout()
            return false
        }
    }


    async function login(username, password) {
        try {
            const response = await executeJWTAuthenticationService(username, password)

            if (response.status == 200) {
                const jwtToken = 'Bearer ' + response.data.token

                setAuthenticated(true)
                setUserName(username)
                setToken(jwtToken)

                apiClient.interceptors.request.use(
                    (config) => {
                        console.log('Adding a token')
                        config.headers.Authorization = jwtToken
                        return config
                    }
                )

                return true
            } else {
                logout()
                return false
            }
        } catch (error) {
            console.log(error)
            logout()
            return false
        }
    }

    function logout() {
        setAuthenticated(false)
        setToken(null)
        setUserName(null)
    }

    // setInterval(() => {
    //     setNumber(number + 1)
    // }, 10000)

    return (
        <AuthContext.Provider value={{ number, isAuthenticated, login, logout, userName, token }}>
            {children}
        </AuthContext.Provider>
    );
}