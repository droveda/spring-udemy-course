import { ErrorMessage, Field, Form, Formik } from "formik"
import { useEffect, useState } from "react"
import { useNavigate, useParams } from "react-router-dom"
import { createTodoApi, retrieveTodoApi, updateTodoApi } from "./api/TodoApiService"
import { useAuth } from "./security/AuthContext"
import moment from 'moment'

export default function TodoComponent() {

    const { id } = useParams()
    const authContext = useAuth()

    const [description, setDescription] = useState('')
    const [targetDate, setTargetDate] = useState('')

    const navigave = useNavigate()

    useEffect(() => {
        retrieveTodos()
    }
        , [id]
    )

    function retrieveTodos() {
        if (id != -1) {
            retrieveTodoApi(authContext.userName, id)
                .then(response => {
                    //console.log(response)
                    setDescription(response.data.description)
                    setTargetDate(response.data.targetDate)
                })
                .catch(error => {
                    console.log(error)
                })
        }
    }

    function onSubmit(values) {
        // console.log(values)
        const todo = {
            id: id,
            username: authContext.userName,
            description: values.description,
            targetDate: values.targetDate,
            done: false
        }

        console.log(todo)

        if (id == -1) {

            createTodoApi(authContext.userName, todo)
            .then(response => {
                console.log(response)
                navigave(`/todos`)
            })
            .catch(error => {
                console.log(error)
            })

        } else {

            updateTodoApi(authContext.userName, id, todo)
                .then(response => {
                    console.log(response)
                    navigave(`/todos`)
                })
                .catch(error => {
                    console.log(error)
                })
        }
    }

    function validate(values) {
        let errors = {
            //description: 'Enter a valid description',
            //targetDate: 'Enter a valid target date'
        }
        console.log(values)

        if (values.description.length < 5) {
            errors.description = 'Enter at least five charecters'
        }

        if (values.targetDate == null || values.targetDate == '' || !moment(values.targetDate).isValid()) {
            errors.targetDate = 'Enter a valid target date'
        }

        return errors
    }

    return (
        <div className="container">
            <h1>Enter Todo Details</h1>
            <div>
                <Formik enableReinitialize={true}
                    initialValues={{ description, targetDate }}
                    onSubmit={onSubmit}
                    validate={validate}
                    validateOnChange={false}
                    validateOnBlur={false}>
                    {
                        (props) => (
                            <Form>
                                <ErrorMessage name="description" component="div" className="alert alert-warning" />
                                <ErrorMessage name="targetDate" component="div" className="alert alert-warning" />

                                <fieldset className="form-group">
                                    <label htmlFor="description">Description</label>
                                    <Field className="form-control" type="text" name="description" />
                                </fieldset>
                                <fieldset className="form-group">
                                    <label htmlFor="targetDate">Target Date</label>
                                    <Field className="form-control" type="date" name="targetDate" />
                                </fieldset>
                                <div>
                                    <button className="btn btn-success m-5" type="submit">Save</button>
                                </div>
                            </Form>
                        )
                    }
                </Formik>
            </div>
        </div>
    )
}