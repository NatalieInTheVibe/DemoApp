import React, {useEffect, useState} from 'react'
import axios from 'axios'
import {Link} from 'react-router-dom'

export default function Home() {
    const [members, setMembers] = useState([])
    useEffect(() => {
        loadMembers();
    }, []);

    const loadMembers = async () => {
        const result = await axios.get("http://localhost:8080/memberDetails/memberList");
        setMembers(result.data);
    };
    
    const deleteMember = async (mbrNo) => {
        await axios.delete(`http://localhost:8080/memberDetails/deleteMember/${mbrNo}`);
        loadMembers();
    }


  return (
    <div className='container'>
        <div className='py-4'>
            <table className="table border shadow">
            <thead>
                <tr>
                <th scope="col">#</th>
                <th scope="col">Name</th>
                <th scope="col">Membership Tier</th>
                <th scope="col">Gender</th>
                <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody>
                {members.map((member, index) => (
                     <tr>
                     <th scope="row" key = {index}>{member.mbrNo}</th>
                     <td>{member.mbrName}</td>
                     <td>{member.mbrTier}</td>
                     <td>{member.mbrSex}</td>
                     <td>
                        <Link className="btn btn-primary mr-2 mx-2" to={`/memberList/viewMember/${member.mbrNo}`} >View</Link>
                        <Link className="btn btn-outline-primary mr-2" to={`/memberList/updateMember/${member.mbrNo}`}>Edit</Link>
                        <button className="btn btn-danger mx-2" onClick={()=>deleteMember(member.mbrNo) }>Delete</button>
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
