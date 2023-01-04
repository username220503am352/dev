import './App.css';
import Student from './component/Student';

function App() {

  return (
    <div className="App">

      <Student name="심원용" score="100" />
      <Student name="홍길동" score="200" />
      <Student name="김철수" score="300" />

    </div>
  );
}

export default App;
