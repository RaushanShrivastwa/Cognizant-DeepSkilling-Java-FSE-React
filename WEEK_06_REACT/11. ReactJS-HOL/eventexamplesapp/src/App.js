import React, { useState } from 'react';
import './App.css';

function App() {
  const [count, setCount] = useState(0);
  const [message, setMessage] = useState('');

  return (
    <div className="event-app">
      <h1>React Event Examples</h1>
      <div className="actions">
        <button onClick={() => setCount((value) => value + 1)}>Add attendee</button>
        <button onClick={() => setCount((value) => Math.max(0, value - 1))}>Remove attendee</button>
      </div>

      <p>
        Current attendees: <strong>{count}</strong>
      </p>

      <input
        value={message}
        onChange={(event) => setMessage(event.target.value)}
        placeholder="Type a quick update..."
      />

      <p>{message ? `Latest update: ${message}` : 'Type an update to preview it here.'}</p>
    </div>
  );
}

export default App;
