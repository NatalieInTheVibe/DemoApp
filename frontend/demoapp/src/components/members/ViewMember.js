import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom'
import axios from 'axios'

export default function ViewMember() {
    const [member, setMember] = useState({});
    const [enrolledEvent, setEnrolledEvent] = useState([]);
    const [availableEvent, setAvailableEvent] = useState([]);
    const [selectedEvent, setSelectedEvent] = useState('');
    const {mbrNo} = useParams();

    const enrollEvent = async () => {
        if (selectedEvent) {
            try {
                await axios.put(`http://localhost:8080/memberDetails/memberList/${mbrNo}/events/${selectedEvent}`);
                alert('Member successfully enrolled in the event.');
    
                // Reload member data to update the enrolled events list
                const result = await axios.get(`http://localhost:8080/memberDetails/getMemberById/${mbrNo}`);
                setMember(result.data);
    
                // Reset the selected event
                setSelectedEvent('');
            } catch (error) {
                console.error('Error enrolling in event:', error);
                alert('Failed to enroll in the event. Please try again.');
            }
        } else {
            alert('Please select an event to enroll.');
        }
    };

    useEffect(() => {
        const loadMember = async () => {
            const result = await axios.get(`http://localhost:8080/memberDetails/getMemberById/${mbrNo}`);
            setMember(result.data);
        };
        loadMember();
        const loadEnrolledEvent = async () => {
            const result = await axios.get(`http://localhost:8080/memberDetails/getMemberById/${mbrNo}/events`);
            setEnrolledEvent(result.data);
        }
        loadEnrolledEvent();
        const loadAvailableEvent = async () => {
            const result = await axios.get(`http://localhost:8080/eventDetails/eventList`);
            setAvailableEvent(result.data);
        };
        loadAvailableEvent();
        // console.log(member.events);
    }, [member]);

    

  return (
    <div className='container'>
        <div className='row'>
        <div className='col-md-4 offset-md-1 border rounded p-4 mt-2 shadow'>
        <h2 className='text-center m-4'>View Member Details</h2>
        <div className='card'>
            <div className='card-header'>Details of Member Number: 
            </div>
            <div className='card-body'>
                <ul className='list-group list-group-flush'>
                    <li className='list-group-item' key={member.mbrNo}>
                        <b>Member Number: </b>
                        {member.mbrNo}
                    </li>
                    <li className='list-group-item' key={member.mbrName}>
                        <b>Member Name: </b>
                        {member.mbrName}
                    </li>
                    <li className='list-group-item' key={member.mbrTier}>
                        <b>Member Tier: </b>
                        {member.mbrTier}
                    </li>
                    <li className='list-group-item' key={member.mbrSex}>
                        <b>Member Gender: </b>
                        {member.mbrSex}
                    </li>
                </ul>
            </div>
        </div>
        <Link className='btn btn-outline-primary mt-2' to={`/memberList`} >Back</Link>
        </div>

        <div className='col-md-4 offset-md-1 border rounded p-4 mt-2 shadow'>
        <h2 className='text-center m-4'>View Enrollment Details</h2>
        <div className='card'>
            <div className='card-header'>Details of Event enrolled: </div>
            <div className='card-body'>
                
                    {enrolledEvent && enrolledEvent !== null && 
                    enrolledEvent.map((event) => {
                        // console.log('Event Number:', event.evtNo);
                        return (
                            <>
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
                            </>
                        )
                    })}
                    <select
                        value={selectedEvent}
                        onChange={(e) => setSelectedEvent(e.target.value)}
                        >
                        <option value="">Select an event</option>
                        {availableEvent
                            .filter((event) => !enrolledEvent.some((e) => e.evtNo === event.evtNo))
                            .map((event) => (
                            <option key={event.evtNo} value={event.evtNo}>
                                {event.evtName}
                            </option>
                            ))}
                    </select>
                    <button className="btn btn-primary mt-2" onClick={enrollEvent}>Enroll in Event</button>

                    {/* // <li className='list-group-item' key={member.}>
                    //     <b>Member Number: </b>
                    //     {member.mbrNo}
                    // </li>
                    // <li className='list-group-item' key={member.mbrName}>
                    //     <b>Member Name: </b>
                    //     {member.mbrName}
                    // </li>
                    // <li className='list-group-item' key={member.mbrTier}>
                    //     <b>Member Tier: </b>
                    //     {member.mbrTier}
                    // </li>
                    // <li className='list-group-item' key={member.mbrSex}>
                    //     <b>Member Gender: </b>
                    //     {member.mbrSex}
                    // </li> */}
                
            </div>
        </div>
        </div>
        </div>

        
    </div>

  )
}
