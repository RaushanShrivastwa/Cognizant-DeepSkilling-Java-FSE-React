import './App.css';

function App() {
  const welcomeRows = [
    'Welcome to your first React demonstration!',
    'This app shows how easy it is to build UI with components.',
    'Change the text and see React refresh the page automatically.'
  ];

  return (
    <main className="hero">
      <h1>React Kickoff</h1>
      <ul>
        {welcomeRows.map((row, idx) => (
          <li key={idx}>{row}</li>
        ))}
      </ul>
    </main>
  );
}

export default App;
