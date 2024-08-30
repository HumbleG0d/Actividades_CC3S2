const client = require('prom-client');
const express = require('express');
const app = express();

const collectDefaultMetrics = client.collectDefaultMetrics;
collectDefaultMetrics();

app.get('/metrics', async (req, res) => {
    try {
      res.set('Content-Type', client.register.contentType);
      const metrics = await client.register.metrics(); // Espera la resolución de la promesa
      res.end(metrics);
    } catch (error) {
      res.status(500).end(error.message); // Manejo de errores
    }
  });

module.exports = app;