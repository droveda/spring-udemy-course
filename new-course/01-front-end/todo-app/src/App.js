import logo from './logo.svg';
import './App.css';
//import LearningComponent from './components/learning-examples/LearningComponent';
import Counter from './components/counter/Counter';
function App() {
  return (
    <div className="App">
      <br />
      <Counter />
    </div>
  );
}

// function PlayingWithProps(properties) {
//   console.log(properties);
//   console.log(properties.property1);
//   console.log(properties.property2);

//   return (
//     <div>
//       Props
//     </div>
//   )
// } 


function PlayingWithProps({property1, property2}) {
  console.log(property1);
  console.log(property2);

  return (
    <div>
      Props
    </div>
  )
} 

export default App;
