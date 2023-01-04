import './App.css';
import Header from './component/Header';
import { BrowserRouter, Route, Routes } from "react-router-dom";

function App() {
  return (
    
    
    
    <div className="App">
      <h1>welcome ~ !</h1>

      <BrowserRouter>
        <Routes>
          <Route path='/main/*' element={<Header />} />
        </Routes>
      </BrowserRouter>

    </div>


  );
}

export default App;
