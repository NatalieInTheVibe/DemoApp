import React, {useEffect, useState} from 'react'
import axios from 'axios'
import {Link} from 'react-router-dom'

export default function Event() {
    const [events, setEvents] = useState([])
    useEffect(() => {
        loadEvents();
    }, []);

    const loadEvents = async () => {
        const result = await axios.get("http://localhost:8080/eventDetails/eventList");
        setEvents(result.data);
    };
    
    const deleteEvent = async (evtNo) => {
        await axios.delete(`http://localhost:8080/eventDetails/deleteEvent/${evtNo}`);
        loadEvents();
    }


  return (
    <div className='container'>
        <div className='py-4'>
            <table className="table border shadow">
            <thead>
                <tr>
                <th scope="col">#</th>
                <th scope="col">Name</th>
                </tr>
            </thead>
            <tbody>
                {events.map((event, index) => (
                     <tr>
                     <th scope="row" key = {index}>{event.evtNo}</th>
                     <td>{event.evtName}</td>
                     <td>
                        <Link className="btn btn-primary mr-2 mx-2" to={`/eventList/viewEvent/${event.evtNo}`} >View</Link>
                        {/* <Link className="btn btn-outline-primary mr-2" to={`/eventList/updateEvent/${event.evtNo}`}>Edit</Link> */}
                        <button className="btn btn-danger mx-2" onClick={()=>deleteEvent(event.evtNo) }>Delete</button>
                     </td>
                     </tr>
                ))
                }
            </tbody>
            </table>
        </div>
    </div>
  )
}
