import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faLinkedin, faGithub, faInstagram } from '@fortawesome/free-brands-svg-icons'; 
import '../../movie-components/movie-footer/movie-footer';

const Footer = () => {  
  return (
    <footer className="footer">
      <p>&copy; 2023 Movie Catalogs</p>
      <p>&copy; Development by Paulo Henrique and Reynan Paiva</p>
      <div className="social-links">
        <a href="#" target="_blank" rel="noopener noreferrer" >
        <FontAwesomeIcon icon={faLinkedin}/> LinkedIn
        </a>
        <a href="#" target="_blank" rel="noopener noreferrer">
        <FontAwesomeIcon icon={faGithub} /> GitHub
        </a>
        <a href="#" target="_blank" rel="noopener noreferrer">
          <FontAwesomeIcon icon={faInstagram} /> Instagram</a>
      </div>
    </footer>
  );
};export default Footer;