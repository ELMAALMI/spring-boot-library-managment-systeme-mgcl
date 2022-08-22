/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [],
  mode: process.env.NODE_ENV ? 'jit' : undefined,
  purge:["./src/**/*.html","./src/**/*.js"],
  theme: {
    extend: {},
  },
  plugins: [],
}
