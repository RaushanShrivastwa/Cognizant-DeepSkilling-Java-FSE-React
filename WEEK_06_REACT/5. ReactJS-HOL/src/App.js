import React from 'react';
import CohortDetails from './CohortDetails';
import { CohortsData } from './Cohort';
import './App.css';

function App() {
  return (
    <div className="cohort-tracker">
      <h1>Cohort Tracker</h1>
      <div className="cohort-grid">
        {CohortsData.map((cohort) => (
          <CohortDetails key={cohort.cohortCode} cohort={cohort} />
        ))}
      </div>
    </div>
  );
}

export default App;
