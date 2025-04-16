

function Authentication({ children }) {
    return (
        <section className="flex justify-center items-center size-full min-h-screen">
            <div className="relative hidden md:flex flex-col flex-1 text-white size-full bg-primary">
                <p className="mt-auto px-10 py-16 text-xl opacity-80"> “A Bidirectional ClickHouse & Flat File Data Ingestion Tool. Manage and convert your large data more efficiently”</p>
            </div>
            {children}
        </section>
    )
}

export default Authentication;