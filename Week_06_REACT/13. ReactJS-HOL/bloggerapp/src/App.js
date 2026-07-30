import './App.css';

const posts = [
  {
    id: 1,
    title: 'A fresh take on blogging',
    summary: 'Use React to turn story ideas into a fast and interactive blog layout.'
  },
  {
    id: 2,
    title: 'Styling with React',
    summary: 'Combine simple HTML with component styling for a modern reading experience.'
  },
  {
    id: 3,
    title: 'From draft to publish',
    summary: 'Manage post previews and publish status with React-friendly structures.'
  }
];

function App() {
  return (
    <main className="blogger-app">
      <h1>Quick Blogger</h1>
      <div className="post-grid">
        {posts.map((post) => (
          <article key={post.id}>
            <h2>{post.title}</h2>
            <p>{post.summary}</p>
          </article>
        ))}
      </div>
    </main>
  );
}

export default App;
