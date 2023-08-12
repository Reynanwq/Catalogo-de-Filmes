import { Link } from "react-router-dom";
import './movie-header.css';

const movie_header = () => {
  return(
    <header className="header">
      <h1>Movie Catalogs</h1>
      <div className="org-header">
          <Link to='/' className="no-underline">
            <p>Home</p>
          </Link>
          <Link to='/favorite' className="no-underline">
            <p>Favorites</p>
          </Link>
      </div>
    </header>
  ) 
};

export default movie_header;