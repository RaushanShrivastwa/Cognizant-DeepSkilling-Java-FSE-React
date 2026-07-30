function percentToDecimal(value) {
  return Math.round(Math.min(100, value * 100));
}

function gradeForScore(percent) {
  if (percent >= 90) return 'A';
  if (percent >= 75) return 'B';
  if (percent >= 60) return 'C';
  return 'D';
}

function CalculateScore({ Name, School, total, goal }) {
  const percent = percentToDecimal(total / goal);

  return (
    <div className="score-card">
      <h2>Student Details</h2>
      <p><strong>Name:</strong> {Name}</p>
      <p><strong>School:</strong> {School}</p>
      <p><strong>Total:</strong> {total} Marks</p>
      <p><strong>Percentage:</strong> {percent}%</p>
      <p><strong>Grade:</strong> {gradeForScore(percent)}</p>
    </div>
  );
}

export default CalculateScore;
