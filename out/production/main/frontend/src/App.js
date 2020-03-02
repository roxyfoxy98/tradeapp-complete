import React, { Component } from 'react';

class App extends Component {
  state = {
    todos: []
  }
  componentDidMount() {
    fetch('/instruments')
    .then(res => res.json())
    .then((data) => {
      this.setState({ todos: data })
      console.log(this.state.todos)
    })
    .catch(console.log)
  }
  render() {

    return (
      <div>
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
    );
  }
  }

export default App;