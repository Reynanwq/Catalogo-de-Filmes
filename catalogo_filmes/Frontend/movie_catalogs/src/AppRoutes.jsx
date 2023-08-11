import { BrowserRouter, Routes, Route} from 'react-router-dom';
import App from './App.jsx';
import Movie from './pages/Movies/movies.jsx'
import Favorites from './pages/Favorites/favorites.jsx';

function AppRoutes(){
  return(
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<App />}/>
        <Route path="/movie" element={<Movie />}/>
        <Route path="/favorites" element={<Favorites />}/>
        <Route path="*" element={Error}></Route>
      </Routes>
    </BrowserRouter>
  );
}

export default AppRoutes;