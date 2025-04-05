import { useState } from 'react';
import { Link, useParams } from 'react-router-dom';
import { retrieveHelloWorldPathVariable } from './api/HelloWorldApiService';
import { useAuth } from './security/AuthContext';

export default function WelcomeComponent() {

    const { username } = useParams()
    const authContext = useAuth()

    const [message, setMessage] = useState(null)

    function callHelloWorld() {
        console.log('called')

        // retrieveHelloWorldBean()
        //     .then((response) => success(response))
        //     .catch((error) => errorResponse(error))
        //     .finally(() => console.log('cleanup')) // optional

        retrieveHelloWorldPathVariable('DRoveda', authContext.token)
            .then((response) => success(response))
            .catch((error) => errorResponse(error))
            .finally(() => console.log('cleanup')) // optional
    }

    function success(response) {
        console.log(response)
        setMessage(response.data.message)
    }

    function errorResponse(error) {
        console.log(error)
    }

    return (
        <div className="Welcome">
            <h1>Welcome to ABC WebSite</h1>
            <div>
                Welcome {username}
                <p>
                    Your todos - <Link to='/todos'>Go Here</Link>
                </p>
            </div>
            <div>
                <button className="btn btn-success" onClick={callHelloWorld}>Call Hello World REST API</button>
            </div>
            <div className='text-info'>
                {message}
            </div>
        </div>
    )
}