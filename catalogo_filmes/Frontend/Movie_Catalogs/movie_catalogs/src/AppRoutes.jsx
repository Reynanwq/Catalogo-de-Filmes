import { BrowserRouter, Routes, Route} from 'react-router-dom';
import App from './App.jsx';
import Favorite from './pages/favorite/favorite.jsx';

function AppRoutes(){
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<App />}/>
        <Route path='/favorite' element={<Favorite />}/>
        <Route path='*' element={Error}></Route>
      </Routes>
    </BrowserRouter>
  );
}

export default AppRoutes;

