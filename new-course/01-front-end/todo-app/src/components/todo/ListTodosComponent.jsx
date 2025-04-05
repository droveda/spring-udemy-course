import { useEffect, useState } from "react"
import { deleteTodoApi, retrieveAllTodosForUsername } from "./api/TodoApiService"
import { useAuth } from "./security/AuthContext"
import { useNavigate } from "react-router-dom"

export default function ListTodosComponent() {

    const today = new Date()
    // const targetDate = new Date(today.getFullYear() + 12, today.getMonth(), today.getDay())

    const authContext = useAuth()
    const username = authContext.userName

    const navigave = useNavigate()

    const [todos, setTodos] = useState([])
    const [message, setMessage] = useState(null)

    useEffect(() => {
        refreshTodos()
    }
        , []
    )

    function refreshTodos() {
        retrieveAllTodosForUsername(username)
            .then(response => {
                // console.log(response)
                setTodos(response.data)
            })
            .catch(error => {
                console.log(error)
            })
    }

    function updateTodo(id) {
        console.log('update called!' + id)
        navigave(`/todo/${id}`)
    }

    function deleteTodo(id) {
        console.log('delete called!' + id)
        deleteTodoApi(username, id)
            .then(() => {
                setMessage(`Delete todo ${id} successful!`)
                refreshTodos()
            }).catch(error => {
                console.log(error)
            })
    }

    function addTodo() {
        navigave(`/todo/-1`)
    }



    return (
        <div className="container">
            <h1>Things you want to do!</h1>

            {message && <div className="alert alert-warning">{message}</div>}

            <div>
                <table className='table table-striped'>
                    <thead>
                        <tr>
                            <th>Description</th>
                            <th>Is Done?</th>
                            <th>Target Date</th>
                            <th>Update</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            todos.map(todo => (
                                <tr key={todo.id}>
                                    <td>{todo.description}</td>
                                    <td>{todo.done.toString()}</td>
                                    <td>{todo.targetDate}</td>
                                    <td>
                                        <button className="btn btn-success" onClick={() => { updateTodo(todo.id) }}>Update</button>
                                    </td>
                                    <td>
                                        <button className="btn btn-warning" onClick={() => { deleteTodo(todo.id) }}>Delete</button>
                                    </td>
                                </tr>
                            )
                            )
                        }
                    </tbody>
                </table>
            </div>
            <div className="btn btn-success m-5" onClick={() => { addTodo() }}>
                Add New Todo
            </div>
        </div>
    )
}