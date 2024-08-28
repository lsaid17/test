// src/components/Search.js
import React, { useState } from "react";
import axios from "axios";
import CircularProgress from "@mui/material/CircularProgress";
import { Button, TextField } from "@mui/material";

const Search = () => {
  const [query, setQuery] = useState("");
  const [result, setResult] = useState(null);
  const [isLoading, setIsLoading] = useState(false);

  const handleSearch = async (e) => {
    e.preventDefault();
    setIsLoading(true);
    await axios
      .get(`http://localhost:8085/test/rest-api/get/card-information/${query}`)
      .then((res) => {
        setResult(res.data);
        setIsLoading(false);
      })
      .catch((err) => {
        setIsLoading(false);
        console.log(err);
      });
  };

  return (
    <div className="container mt-5">
      <div className="row">
        <div className="col-md-6 offset-md-3">
          {isLoading ? (
            <CircularProgress size={20} />
          ) : (
            <div className="input-group mb-3">
              <TextField
                fullWidth
                type="text"
                className="form-control"
                value={query}
                onChange={(e) => setQuery(e.target.value)}
                placeholder="Ingresa el serial de tu tarjeta"
              />
              <Button
              style={{margin:10}}
                variant="contained"
                onClick={(e) => handleSearch(e)}
              >
                Buscar
              </Button>
            </div>
          )}

          {
            <div className="card">
              <div className="card-body">
                <h5 className="card-title">Resultado de {query}</h5>
                <TextField
                  fullWidth
                  style={{ margin: 10 }}
                  disabled={true}
                  id="outlined-read-only-input"
                  label="Nombre de propietario"
                  value={result ? result.userName : ""}
                />
                <TextField
                  fullWidth
                  style={{ margin: 10 }}
                  disabled={true}
                  label="Perfil"
                  value={result ? result.profile : ""}
                />
                <TextField
                  fullWidth
                  style={{ margin: 10 }}
                  disabled={true}
                  label="Saldo"
                  value={result ? result.balance : ""}
                />
                <TextField
                  fullWidth
                  style={{ margin: 10 }}
                  disabled={true}
                  label="Saldo virtual"
                  value={result ? result.virtualBalance : ""}
                />
              </div>
            </div>
          }
        </div>
      </div>
    </div>
  );
};

export default Search;
