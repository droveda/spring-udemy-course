import { apiClient } from "./ApiClient"

export function retrieveHelloWorldBean() {
    return apiClient.get('/hello-bean')
}

export const retrieveHelloWorld = () => apiClient.get('/hello')

export const retrieveHelloWorldPathVariable = (username, token) => apiClient.get(`/hello-world/path-variable/${username}`, {
    headers: {
        Authorization: token
    }
})


