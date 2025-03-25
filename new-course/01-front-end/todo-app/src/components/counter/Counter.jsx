import { useState } from 'react';
import './CounterButton.css';
import CounterButton from './CounterButton';

export default function Counter() {
    const [count, setCount] = useState(0)

    function incrementMethod(by) {
        setCount(count + by)
    }

    function decrementMethod(by) {
        setCount(count - by)
    }

    function resetCounter() {
        setCount(0)
    }

    return (
        <>
            <span className="totalCount">{count}</span>
            <CounterButton by={1} 
                incrementMethod={incrementMethod} 
                decrementMethod={decrementMethod} />
            <CounterButton by={2} 
                incrementMethod={incrementMethod} 
                decrementMethod={decrementMethod} />
            <CounterButton by={5} 
                incrementMethod={incrementMethod} 
                decrementMethod={decrementMethod} />

            <button className="resetButton"
                    onClick={resetCounter}>
                    Reset
            </button>
        </>
    )
}

