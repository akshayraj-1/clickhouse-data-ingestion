import {useState} from "react";
import SourceSelectionCard from "../components/SourceSelectionCard.jsx";
import ClickHouseCard from "../components/ClickHouseCard.jsx";
import FlatFileCard from "../components/FlatFileCard.jsx";

const steps = [
    {
        id: 1,
        title: "Select Source",
        description: "Please select data source"
    },
    {
        id: 2,
        title: "ClickHouse Info",
        description: "Please configure ClickHouse"
    },
    {
        id: 3,
        title: "Flat File Info",
        description: "Please configure Flat File"
    }
];

function Home() {

    const [currentStep, setCurrentStep] = useState(1);
    const [selectedSource, setSelectedSource] = useState(null);

    return (
        <section className="relative flex flex-col gap-1 justify-start items-center pt-16 scroll-m-2 size-full">
            <div className="flex flex-col gap-10 w-fit">
                <div className="flex items-center gap-10">
                    {
                        steps.map(step => {
                            return (
                                <button key={step.id} className={`flex items-start gap-3 px-4 py-4 cursor-pointer rounded-lg disabled:cursor-default
                                ${currentStep !== step.id ? "opacity-50" : ""}`} disabled={true} onClick={() => setCurrentStep(step.id)}>
                                    <span className={`flex justify-center items-center size-10 rounded-full select-none 
                                    ${currentStep === step.id ? "text-white bg-primary" : "border"}`}>{step.id}</span>
                                    <div className="flex flex-col text-start justify-start">
                                        <h3 className="font-semibold text-primary">{step.title}</h3>
                                        <p className="text-sm text-gray-500">{step.description}</p>
                                    </div>
                                </button>
                            )
                        })
                    }
                </div>
                <div className="p-5 w-full">
                    {
                        currentStep === 1
                            ? <SourceSelectionCard onSubmit={(source) => {
                                setSelectedSource(source);
                                setCurrentStep(prev => prev + 1);
                            }}/>
                            : currentStep === 2
                                ? <ClickHouseCard/>
                                : <FlatFileCard/>
                    }
                </div>
            </div>
        </section>
    );
}

export default Home;