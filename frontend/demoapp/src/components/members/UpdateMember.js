import React, {useState} from 'react'
import axios from 'axios'
import {useNavigate, useParams} from 'react-router-dom'

export default function UpdateMember() {
  let navigate = useNavigate();

  const mbrNo = useParams().mbrNo;
  const [member, setMember] = useState({
    mbrName:"",
    mbrTier:"",
    mbrSex:""
  })

  const {mbrName, mbrTier, mbrSex} = member;
  const onInputChange = (e) => {
    setMember({...member, [e.target.name]: e.target.value});
  }

  const onSubmit = async (e) => {
    e.preventDefault();
    await axios.put(`http://localhost:8080/memberDetails/updateMember/${mbrNo}`, member);
    console.log(member);
    navigate("/");
  }

  const cancel = () => {
    navigate(-1); // Navigate to the previous page
  }

  return (
    <div className='container'>
        <div className='col-md-6 offset-md-3 border rounded p-4 mt-2 shadow'>
        <form onSubmit={e => onSubmit(e)}>
        <h2 className='text-center m-4'>Update Member</h2>
        <div className='mb-3'>
            <label for='name' className='form-label'>Name</label>
            <input value={mbrName} name='mbrName' onChange={(e)=>onInputChange(e)} type='text' className='form-control' id='name' placeholder={'Enter Name'}/>
        </div>
        <div className='mb-3'>
            <label for='tier' className='form-label'>Tier</label>
            <input value={mbrTier} name='mbrTier' onChange={(e)=>onInputChange(e)} type='text' className='form-control' id='tier' placeholder='Enter Member Tier'/>
        </div>
        <div className='mb-3'>
            <label for='sex' className='form-label'>Gender</label>
            <input value={mbrSex} name='mbrSex' onChange={(e)=>onInputChange(e)} type='text' className='form-control' id='sex' placeholder='Enter Gender'/>
        </div>
        <button type='submit' className='btn btn-outline-primary'>Submit</button>
        <button type='button' onClick={cancel} className='btn btn-outline-danger mx-2'>Cancel</button>
        </form>
        </div>
    </div>

  )
}
