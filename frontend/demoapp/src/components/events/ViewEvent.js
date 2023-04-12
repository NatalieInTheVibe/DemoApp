import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom'
import axios from 'axios'

export default function ViewEvent() {
    const [event, setEvent] = useState({
  
    });
    const {evtNo} = useParams();

    useEffect(() => {
        const loadEvent = async () => {
            const result = await axios.get(`http://localhost:8080/eventDetails/getEventById/${evtNo}`);
            setEvent(result.data);
        };
        loadEvent();
    }, [evtNo]);

    

  return (
    <div className='container'>
        <div className='col-md-6 offset-md-3 border rounded p-4 mt-2 shadow'>
        <h2 className='text-center m-4'>View Event Details</h2>
        <div className='card'>
            <div className='card-header'>Details of Event Number: 
            </div>
            <div className='card-body'>
                <ul className='list-group list-group-flush'>
                    <li className='list-group-item' key={event.evtNo}>
                        <b>Event Number: </b>
                        {event.evtNo}
                    </li>
                    <li className='list-group-item' key={event.evtName}>
                        <b>Event Name: </b>
                        {event.evtName}
                    </li>
                </ul>
            </div>
        </div>
        <Link className='btn btn-outline-primary mt-2' to={`/eventList`} >Back</Link>
        </div>
    </div>

  )
}
