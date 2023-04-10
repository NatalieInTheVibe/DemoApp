import React from 'react'
import { Link } from 'react-router-dom'

export default function NavBar() {
  return (
    <div>
        <nav className="navbar navbar-expand-lg navbar-dark bg-primary">
            <div className="container-fluid">
                <a className="navbar-brand" href="/">Membership Management Application</a>
                <button className="navbar-toggler" 
                type="button" 
                data-toggle="collapse" 
                data-target="#navbarSupportedContent" 
                aria-controls="navbarSupportedContent" 
                aria-expanded="false" 
                aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="navbar-nav ml-auto">
                  <Link className="btn btn-outline-light" to="/">
                    Home
                  </Link>
                  <Link className="btn btn-outline-light mx-2" to="/memberList/saveMember">
                    Add Member
                  </Link>
                </div>
            </div>
        </nav>
    </div>
  )
}
