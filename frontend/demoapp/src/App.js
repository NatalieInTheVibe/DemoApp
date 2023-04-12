import './App.css';
import NavBar from './components/NavBar';
import 'bootstrap/dist/css/bootstrap.min.css';
import Member from './pages/Member';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import SaveMember from './components/members/SaveMember';
import UpdateMember from './components/members/UpdateMember';
import ViewMember from './components/members/ViewMember';
import Home from './pages/Home';
import Event from './pages/Event';
import SaveEvent from './components/events/SaveEvent';
import ViewEvent from './components/events/ViewEvent';


function App() {
  return (
    <div className="App">
      <Router> 
        <NavBar/>
      
        <Routes>
          <Route path="/" element={<Home/>}/>
          <Route path="/memberList" element={<Member/>}/>
          <Route path="/eventList" element={<Event/>}/>
          <Route path="/memberList/saveMember" element={<SaveMember/>}/>
          <Route path="/eventList/saveEvent" element={<SaveEvent/>}/>
          <Route path="/memberList/updateMember/:mbrNo" element={<UpdateMember/>}/>
          {/* <Route path="/eventList/updateEvent" element={<UpdateEvent/>}/> */}
          <Route path="/memberList/viewMember/:mbrNo" element={<ViewMember/>}/>
          <Route path="/eventList/viewEvent/:evtNo" element={<ViewEvent/>}/>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
