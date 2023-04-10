import './App.css';
import NavBar from './components/NavBar';
import 'bootstrap/dist/css/bootstrap.min.css';
import Home from './pages/Home';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import SaveMember from './components/members/SaveMember';
import UpdateMember from './components/members/UpdateMember';
import ViewMember from './components/members/ViewMember';

function App() {
  return (
    <div className="App">
      <Router> 
        <NavBar/>
      
        <Routes>
          <Route exact path="/" element={<Home/>}/>
          <Route path="/memberList/saveMember" element={<SaveMember/>}/>
          <Route path="/memberList/updateMember/:mbrNo" element={<UpdateMember/>}/>
          <Route path="/memberList/viewMember/:mbrNo" element={<ViewMember/>}/>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
