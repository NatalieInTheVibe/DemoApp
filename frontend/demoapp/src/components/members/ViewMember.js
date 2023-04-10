import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom'
import axios from 'axios'

export default function ViewMember() {
    const [member, setMember] = useState({
  
    });
    const mbrNo = useParams().mbrNo;

    useEffect(() => {
        const loadMember = async () => {
            const result = await axios.get(`http://localhost:8080/memberDetails/getMemberById/${mbrNo}`);
            setMember(result.data);
        };
        loadMember();
    }, [mbrNo]);

    

  return (
    <div className='container'>
        <div className='col-md-6 offset-md-3 border rounded p-4 mt-2 shadow'>
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
        <Link className='btn btn-outline-primary mt-2' to={`/`} >Back</Link>
        </div>
    </div>

  )
}
