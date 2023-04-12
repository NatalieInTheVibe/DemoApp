import React, {useState} from 'react'
import axios from 'axios'
import {useNavigate} from 'react-router-dom'

export default function SaveEvent() {
  let navigate = useNavigate();
  const [event, setEvent] = useState({
    evtName:"",
  })

  const {evtName} = event;
  const onInputChange = (e) => {
    setEvent({...event, [e.target.name]: e.target.value});
  }

  const onSubmit = async (e) => {
    e.preventDefault();
    await axios.post("http://localhost:8080/eventDetails/saveEvent", event);
    console.log(event);
    navigate("/eventList");
  }

  const cancel = () => {
    navigate(-1); // Navigate to the previous page
  }

  return (
    <div className='container'>
      <div className='col-md-6 offset-md-3 border rounded p-4 mt-2 shadow'>
        <form onSubmit={e => onSubmit(e)}>
        <h2 className='text-center m-4'>Register Event</h2>
        <div className='mb-3'>
          <label for='name' className='form-label'>Event Name</label>
          <input value={evtName} name='evtName' onChange={(e)=>onInputChange(e)} type='text' className='form-control' id='name' placeholder='Enter Event Name'/>
        </div>
        <button type='submit' className='btn btn-outline-primary'>Submit</button>
        <button type='button' onClick={cancel} className='btn btn-outline-danger mx-2'>Cancel</button>
        </form>
      </div>
    </div>
  )
}
