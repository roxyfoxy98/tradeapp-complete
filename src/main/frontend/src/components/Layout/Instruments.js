import React, {Component} from 'react';
import { Link } from "react-router-dom";
import axios from 'axios';

class Instruments extends Component {
    constructor() {
        super();
        this.state = {
            todos: []
        };
    }
    componentDidMount() {
        axios.get(`/instruments`)
        .then(res => {
          const instruments = res.data;
          this.setState({
              todos: instruments
          });
        })
    }
    render() {
        return (
            <div className="landing">
                <div className="light-overlay landing-inner text-dark">
                    <div className="container">
                        <div className="row">
                            <div className="col-md-12 text-center">
                            <table border="1">
                                <th>Symbol</th>
                                <th>Description</th>
                                <th>Nominal Value of 1 Lot</th>
                                <th>Pip Value</th>
                                <th>Min Trade Volume</th>
                                <th>Max Trade Volume</th>
                                <th>Margin Rate</th>
                                <th>Trading Hours</th>

                                {this.state.todos.map(el => (
                                    <tr>
                                    <td>{el.symbol}</td>
                                    <td>{el.description}</td>
                                    <td>{el.nominalValueOf1Lot}</td>
                                    <td>{el.pipValue}</td>
                                    <td>{el.minTradeVolume}</td>
                                    <td>{el.maxTradeVolume}</td>
                                    <td>{el.marginRate}</td>
                                    <td>{el.tradingHours}</td>
                                    </tr>
                                ))}
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
        );
    }

} 
export default Instruments;