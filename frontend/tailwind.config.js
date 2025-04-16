/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      borderColor: {
        DEFAULT: "#e4e4e4"
      },
      colors: {
        primary: "#18181b"
      }
    },
  },
  plugins: [],
}

