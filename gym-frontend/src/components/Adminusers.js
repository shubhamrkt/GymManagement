import React, { useEffect, useState } from "react";
import Adminusercard from "./Adminusercard";
import base_url from "../api/bootapi";
import swal from "sweetalert2";
import axios from "axios";
import bgimage from "../images/login-bg2.jpg";

function Adminusers() {
  useEffect(() => {
    document.title = "Users List";
    if (sessionStorage.getItem("admin") != "admin") {
      window.location = "/";
    }
    viewUsers();
  }, []);

  const viewUsers = () => {
    axios.get(`${base_url}/getallusers`).then(
      (response) => {
        if (response.data.length == 0) {
          swal.fire({
            title: "Admin",
            text: "There are no users registered",
            icon: "error",
            button: "Ok",
          });
        }
        setUsers(response.data);
      },
      (error) => {
        console.log(error);
        swal.fire("Server is down");
      }
    );
  };

  const [users, setUsers] = useState([]);
  console.log(users);
  return (
    <div
      className="min-vh-100 mt-5"
      style={{
        backgroundImage: `url(${bgimage})`,
        backgroundPosition: "center",
        backgroundSize: "cover",
        backgroundRepeat: "no-repeat",
      }}
    >
      <div className="container mt-5 pt-5">
        <h1 className=" mb-3 text-center text-white fw-bold">
          View All Members
        </h1>
        <div
          className="card"
          style={{
            backgroundColor: "white",
            opacity: 0.8,
          }}
        >
          <h5 className="card-header">All Members</h5>
          <div className="card-body">
            <table className="table table-hover table-bordered">
              <thead>
                <tr>
                  <th scope="col">Name</th>
                  <th scope="col">City</th>
                  <th scope="col">Phone</th>
                  <th scope="col">E-mail</th>
                  <th scope="col">Password</th>
                  <th scope="col">Security Question</th>
                  <th scope="col">Answer</th>
                  <th scope="col">Admin</th>
                  <th scope="col">Action</th>
                </tr>
              </thead>
              <tbody>
                {users.length > 0 ? (
                  users.map((item) => <Adminusercard user={item} />)
                ) : (
                  <h2 className="text-center m-5 p-5">No Members registered</h2>
                )}
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Adminusers;
