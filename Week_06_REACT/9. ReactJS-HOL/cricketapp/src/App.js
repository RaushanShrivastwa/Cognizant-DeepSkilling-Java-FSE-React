import React, { useState } from 'react';
import './App.css';

function App() {
  const [score, setScore] = useState({ teamA: 192, teamB: 185 });

  return (
    <div className="scoreboard">
      <h1>Cricket Scoreboard</h1>
      <div className="teams">
        <div>
          <h2>Team A</h2>
          <p>{score.teamA} / 10</p>
          <button onClick={() => setScore({ ...score, teamA: score.teamA + 4 })}>Team A +4</button>
        </div>
        <div>
          <h2>Team B</h2>
          <p>{score.teamB} / 10</p>
          <button onClick={() => setScore({ ...score, teamB: score.teamB + 6 })}>Team B +6</button>
        </div>
      </div>
      <p className="lead">Lead: {score.teamA - score.teamB} runs</p>
    </div>
  );
}

export default App;
