import React from 'react';
import './App.css';
import axios from 'axios';

class App extends React.Component { /*this adds a React frontend*/
  state = {
    data: null
  }

  componentDidMount() { /*this connects to the API*/
    axios.get('http://localhost:5000')
    .then((response) => {
      this.setState({
        data: response.data
      })
    })
    .catch((error) => {
      console.error(`Error fetching data: ${error}`);
    })
  }

  render() {
    return (
    <div className="App">
      <header className="App-header">
        Virtual Babysitting App
      </header>
      
      <div className="API-connector">
        {this.state.data/*this references the API connector*/} 
      </div>
    </div>
  );
  }
}

export default App;
