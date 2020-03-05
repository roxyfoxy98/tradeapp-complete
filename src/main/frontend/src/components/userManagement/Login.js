import React, { Component } from 'react';
import PropTypes from 'prop-types';
// import {connect} from 'react-redux';
import classnames from 'classnames';
// import {login, clearErrors} from '../../actions/securityActions';
import { Link } from "react-router-dom";

class Login extends Component {
    constructor() {
        super();
        this.state = {
            username: "",
            password: "",
            errors: {}
        };
        this.onChange = this.onChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
    }
    onChange(e) {
        this.setState({ [e.target.name]: e.target.value });
    }

    onSubmit(e) {
        e.preventDefault();
        const loginRequest = {
            username: this.state.username,
            password: this.state.password
        };
        this.props.login(loginRequest, this.props.history);
    }

    componentWillReceiveProps(nextProps) {
        // if(nextProps.security.validToken) {
        //     this.props.history.push("/dashboard");
        // }
        // if(nextProps.errors) {
        //     this.setState({
        //         errors: nextProps.errors
        //     });
        // }
    }

    render() {
        // const {errors} = this.props;
        return (
        <div className="login">
            <div className="container">
                <div className="row">
                    <div className="col-md-8 m-auto">
                        <h1 className="display-4 text-center">Log In</h1>
                        <form onSubmit = {this.onSubmit}>
                            <div className="form-group">
                                <input type="email" className="form-control form-control-lg"
                                placeholder="Email Address" 
                                name="username" 
                                value = {this.state.username}
                                onChange = {this.onChange}
                                />
                                {/* {
                                    errors && (<div className="invalid-feedback">{errors.username}</div>)
                                } */}
                            </div>
                            <div className="form-group">
                                <input type="password" 
                                className="form-control form-control-lg" 
                                placeholder="Password" 
                                name="password" 
                                value = {this.state.password}
                                onChange = {this.onChange}
                                />
                                {/* {
                                    errors && (<div className="invalid-feedback">{errors.password}</div>)
                                } */}
                            </div>
                            <input type="submit" className="btn btn-info btn-block mt-4" />
                        </form>
                    </div>
                </div>
            </div>
        </div>
        );
    }
}
// Login.propTypes = {
//     login: PropTypes.func.isRequired,
//     errors: PropTypes.object.isRequired,
//     security: PropTypes.object.isRequired,
//     clearErrors: PropTypes.func.isRequired
// };
export default Login;