//Create a Context

import { createContext, useContext, useState } from "react";

export const AuthContext = createContext();

export const useAuth = () => useContext(AuthContext)

//Share the created context with other components
export default function AuthProvider({ children }) {

    //Put some state in the context
    const [number, setNumber] = useState(10)
    const [isAuthenticated, setAuthenticated] = useState(false)

    function login(username, password) {
        if (username === 'in28minutes' && password === 'dummy') {
            setAuthenticated(true)
            return true
        } else {
            setAuthenticated(false)
            return false
        }
    }

    function logout() {
        setAuthenticated(false)
    }

    // setInterval(() => {
    //     setNumber(number + 1)
    // }, 10000)

    return (
        <AuthContext.Provider value={{ number, isAuthenticated, login, logout }}>
           {children}
        </AuthContext.Provider>
    );
}