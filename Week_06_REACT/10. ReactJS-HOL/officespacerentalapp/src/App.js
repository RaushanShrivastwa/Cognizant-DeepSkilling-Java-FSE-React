import './App.css';

const offices = [
  { name: 'Central Tower', area: 'Downtown', rent: '₹25,000/mo', available: true },
  { name: 'Riverfront Suite', area: 'Southside', rent: '₹18,500/mo', available: false },
  { name: 'Maple Workspace', area: 'Tech Park', rent: '₹22,000/mo', available: true }
];

function App() {
  return (
    <div className="office-list">
      <h1>Office Space Rental Options</h1>
      <div className="cards">
        {offices.map((office, index) => (
          <article key={index} className={`office-card ${office.available ? 'available' : 'unavailable'}`}>
            <h2>{office.name}</h2>
            <p>{office.area}</p>
            <p>{office.rent}</p>
            <span>{office.available ? 'Available' : 'Booked'}</span>
          </article>
        ))}
      </div>
    </div>
  );
}

export default App;
