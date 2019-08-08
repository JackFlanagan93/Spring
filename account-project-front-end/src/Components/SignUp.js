import React, { Component } from 'react';
import axios from "axios";

import 'bootstrap/dist/css/bootstrap.css'
import { Form } from 'reactstrap';
import NavBar from "./NavBar.js"


class SignUp extends Component {

    constructor(props) {
        super(props);

        this.state = {
            data: [{
                
                id: "Default ID",
                firstName: "Default firstName",
                lastName: "Default lastName",
                accountNumber: "Default accountNumber",
                prize: "Default prize"

            }]
        }
    }

    componentDidMount = () => {
    }

    createUser = (e) => {
        e.preventDefault()

        const newUser = {
            firstName: e.target[0].value,
            lastName: e.target[1].value,
        }

        const headers = { 'Content-Type': 'application/json' };

        axios.post("http://localhost:8080/account/add", newUser, { headers: headers })
            .then(response => {
                
                this.setState({
                    id: response.data.id,
                    firstName: response.data.firstName,
                    lastName: response.data.lastName,
                    accountNumber: response.data.accountNumber,
                    prize: response.data.prize
                    
                })
               
                document.getElementById("response").innerHTML = `Welcome ${response.data.firstName} your account has been succesfully created!`
                document.getElementById("prizeButton").removeAttribute("disabled");
                
            
            });
   
    
   
    }
    
    showPrize = () => {
        document.getElementById("prize").innerHTML = "test"
    }
   

    render() {
        return (
            <div>
                <center>
                <NavBar/>
                <br/>
                <h4>Sign Up</h4>
                <h4>---------------------------</h4>
                
                <Form id="createUser" onSubmit={this.createUser}>
                    <label>First Name: </label>
                    <br />
                    <input type="text" id="firstName" placeholder="Please Enter your First Name"></input>
                    <br /><br />
                    <label>Last Name: </label>Mi
                    <br />
                    <input type="text" id="lastName" placeholder="Please Enter your Last Name"></input>
                    <br /><br />
                    <button>Add User</button>
                    <br /><br />
                </Form>
                <h4>---------------------------</h4>
                <p id="response" />
                <input type="button" id="prizeButton" disabled onClick="showPrize()" value="! Click To Reveal Prize !"></input>
               <p id="prize" />
                </center>               
            </div>
        );
    }
};
export default SignUp