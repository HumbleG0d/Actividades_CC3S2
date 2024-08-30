const request = require('supertest');
const express = require('express');
const client = require('prom-client');
const app = require('../src/app'); // Asegúrate de que este es el path correcto a tu archivo app.js

describe('GET /metrics', () => {
  it('should return 200 and expose metrics', async () => {
    const response = await request(app).get('/metrics');
    expect(response.status).toBe(200);
    expect(response.headers['content-type']).toBe(client.register.contentType);

    // Aquí podrías verificar que algunas métricas específicas están presentes
    expect(response.text).toContain('# HELP'); // El formato de Prometheus suele comenzar con HELP
  });

  it('should handle errors correctly', async () => {
    // Simula un error en client.register.metrics
    jest.spyOn(client.register, 'metrics').mockImplementation(() => {
      throw new Error('Mock error');
    });

    const response = await request(app).get('/metrics');
    expect(response.status).toBe(500);
    expect(response.text).toBe('Mock error');

    // Limpia el mock
    client.register.metrics.mockRestore();
  });
});
