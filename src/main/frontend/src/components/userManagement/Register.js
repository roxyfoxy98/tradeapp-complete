import React, {Component} from 'react';
// import { createNewUser, clearErrors } from '../../actions/securityActions';
import PropTypes from 'prop-types';
import axios from 'axios';

// import {connect} from 'react-redux';
// import classnames from 'classnames';

class Register extends Component {
    constructor() {
        super();
        this.state = {
            username: "",
            fullName: "",
            password: "",
            confirmPassword: ""
        };
        this.onChange = this.onChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
    }
    componentDidMount() {
        // if(this.props.security.validToken) {
        //     this.props.history.push("/dashboard");
        // }    
        // if (this.props.errors) {
        //     this.props.clearErrors();
        // }
    }
    onChange(e) {
        this.setState({ [e.target.name]: e.target.value });
    }
    onSubmit(e) {
        e.preventDefault();
        const newUser = {
            username: this.state.username,
            fullName: this.state.fullName,
            password: this.state.password,
            confirmPassword: this.state.confirmPassword
        };
        axios.post(`/api/users/register`, newUser);
        this.props.history.push('/register-success');
    }
    // componentWillReceiveProps(nextProps) {
    //     if(nextProps.errors) {
    //         this.setState({
    //             errors: nextProps.errors
    //         });
    //     }
    // }
    render() {
        const {errors} = this.props;
        return (
            <div className="register">
                <div className="container">
                    <div className="row">
                        <div className="col-md-8 m-auto">
                            <h1 className="display-4 text-center">Sign Up</h1>
                            <p className="lead text-center">Create your Account</p>
                            <form onSubmit={this.onSubmit}>
                                <div className="form-group">
                                    <input type="text" className="form-control form-control-lg"placeholder="Username" name="username"
                                        value={this.state.username} 
                                        onChange={this.onChange}
                                        />
                                    {/* {
                                        errors.fullName && (<div className="invalid-feedback">{errors.fullName}</div>)
                                    } */}
                                </div>
                                <div className="form-group">
                                    <input type="text" className="form-control form-control-lg"placeholder="Full name" name="fullName"
                                        value={this.state.fullName} 
                                        onChange={this.onChange}
                                        />
                                    {/* {
                                        errors.fullName && (<div className="invalid-feedback">{errors.fullName}</div>)
                                    } */}
                                </div>
                                <div className="form-group">
                                    <input type="password" className="form-control form-control-lg" placeholder="Password" name="password" value={this.state.password} onChange={this.onChange}/>
                                    {/* {
                                        errors.password && (<div className="invalid-feedback">{errors.password}</div>)
                                    } */}
                                </div>
                                <div className="form-group">
                                    <input type="password" className="form-control form-control-lg" placeholder="Confirm Password" name="confirmPassword" value={this.state.confirmPassword} onChange={this.onChange}/>
                                    {/* {
                                        errors.password && (<div className="invalid-feedback">{errors.password}</div>)
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
// Register.propTypes = {
//     createNewUser: PropTypes.func.isRequired,
//     errors: PropTypes.object.isRequired,
//     security: PropTypes.object.isRequired,
//     clearErrors: PropTypes.func.isRequired
// }
// const mapStateToProps = state => ({
//     errors: state.errors,
//     security: state.security
// });
export default Register;