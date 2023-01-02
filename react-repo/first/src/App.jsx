import './App.css';
import Hello from './component/Hello';

function App() {

  return (
    <div className="App">
      <h1>환영합니다</h1>
      <div className="menu">
        <Hello k01="v01" k02="v02" k03="v03" />
        <Hello k01="갤러리"/>
        <Hello k01="공지사항"/>
        <Hello />
        <Hello />
      </div>
    </div>
  );
}

export default App;
