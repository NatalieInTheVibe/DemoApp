import React from 'react'
import { Link } from 'react-router-dom'

export default function Home() {
  return (
    <>
        <div className='container'>
            <div className='py-4'>
                <Link className="btn btn-primary mr-2 mx-2" to={`/memberList`}>Members</Link>
                <Link className="btn btn-primary mr-2 mx-2" to={`/eventList`}>Events</Link>
            </div>
        </div>
    </>

  )
}
