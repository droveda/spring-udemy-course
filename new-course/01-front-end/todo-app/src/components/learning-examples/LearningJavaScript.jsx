const person = {
    name: "John",
    address: {
        city: "London",
        line1: "Baker Street",
        country: 'UK'
    },
    profiles: ['twitter', 'linkedin', 'instagram'],
    printProfile: () => {
        person.profiles.map(
            (profile) => {
                console.log(profile)
            }
        )
    }
}


export default function LearningJavaScript() {
    return (
        <div>
            <p>{person.name}</p>
            <ol>
                <li>{person.address.line1}</li>
                <li>{person.address.city}</li>
                <li>{person.address.country}</li>
            </ol>
            <p>{person.profiles[0]}</p>

            <div>
                {person.printProfile()}
            </div>
        </div>
    )
}