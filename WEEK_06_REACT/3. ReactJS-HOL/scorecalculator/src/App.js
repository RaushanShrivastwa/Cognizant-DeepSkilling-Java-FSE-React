import './App.css';
import CalculateScore from './Components/CalculateScore';

function App() {
  return (
    <div className="score-app">
      <h1>Score Calculator</h1>
      <CalculateScore
        Name="Steeve"
        School="DNV Public School"
        total={284}
        goal={300}
      />
    </div>
  );
}

export default App;
