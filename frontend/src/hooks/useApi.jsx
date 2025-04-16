import { useState } from "react";

function useApi() {
    const API_URL = import.meta.env.VITE_API_URL;
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);

    async function get(endpoint) {
        try {
            setLoading(true);
            setError(null);
            const response = await fetch(`${API_URL}${endpoint}`, {
                credentials: "include",
            });
            if (!response.ok) {
                const errorData = await response.json();
                setError(errorData?.error || "Something went wrong");
                return null;
            }
            return await response.json();
        } catch (e) {
            setError(e.message);
            return null;
        } finally {
            setLoading(false);
        }
    }

    async function post(endpoint, data, opts = {}) {
        try {
            setLoading(true);
            setError(null);
            const response = await fetch(`${API_URL}${endpoint}`, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                    ...opts.headers
                },
                credentials: "include",
                body: JSON.stringify(data),
            });
            if (!response.ok) {
                const errorData = await response.json();
                setError(errorData?.error || "Something went wrong");
                return null;
            }
            return await response.json();
        } catch (e) {
            setError(e.message);
            return null;
        } finally {
            setLoading(false);
        }
    }

    return { get, post, loading, error };
}

export default useApi;