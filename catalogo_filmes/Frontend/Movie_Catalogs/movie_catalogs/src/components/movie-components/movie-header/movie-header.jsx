import './movie-header.css';

const movie_header = () => {
  return(
    <header className="header">
      <h1>Movie Catalogs</h1>
      <div className="org-header">
            <p>Home</p>
            <p>Favorites</p>
      </div>
    </header>
  )
};

export default movie_header;