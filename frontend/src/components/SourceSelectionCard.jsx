import Button from "./Button.jsx";
import {useState} from "react";

function SourceSelectionCard({onSubmit}) {

    const [source, setSource] = useState(null);

    return (
        <div className="flex flex-col gap-3 justify-center items-center size-full">
            <label
                className="flex items-start gap-4 w-full max-w-xs cursor-pointer border rounded-lg p-4 hover:shadow-md transition-all peer-checked:border-primary">
                <input type="radio" name="option" value="1" className="mt-1 peer" onChange={e => e.target.checked && setSource(e.target.value)}/>
                <div>
                    <p className="text-lg font-semibold">ClickHouse</p>
                    <p className="text-gray-500 text-sm">Select data source as database</p>
                </div>
            </label>

            <label
                className="flex items-start gap-4 w-full max-w-xs cursor-pointer border rounded-lg p-4 hover:shadow-md transition-all peer-checked:border-primary">
                <input type="radio" name="option" value="2" className="mt-1 peer" onChange={e => e.target.checked && setSource(e.target.value)}/>
                <div>
                    <p className="text-lg font-semibold">Flat File</p>
                    <p className="text-gray-500 text-sm">Select data source as csv file</p>
                </div>
            </label>

            <Button onClick={() => source && onSubmit(source)} label="Next" className="mt-4" disabled={source === null} />
        </div>
    );
}

export default SourceSelectionCard;