// alert("testimonals.js has working code in it ")

// need to test if its able to actually get the html elements in the main

let working=document.getElementById("testimonials")


let reviews=[
    `Fair Hand Borrowing Company is a marketplace
    that empowers borrowers by
    providing them with a range of loan options. The platform connects
    borrowers with multiple lenders, enabling them to compare interest rates,
    loan terms, and repayment options. I appreciated the transparency
    offered through detailed lender profiles, allowing me to make`,

    `Fair Hand Borrowing Company exceeded my expectations as a loan marketplace.
    The platform's application process was quick and straightforward, requiring minimal documentation.
    I was pleasantly surprised by how promptly I received loan offers from various lenders. Once I accepted an
    offer, the funds were disbursed to my account in a timely manner. The platform's communication throughout the
    process was commendable, ensuring I was informed of each step. Fair Hand Borrowing Company's
    efficiency in loan processing and fast fund disbursement makes it an excellent choice for individuals in need
    of quick financial assistance.` ,

    `Fair Hand Borrowing Company is a marketplace that truly lives up to its name. The
    platform emphasizes fairness and transparency in its loan services. I found the interest
    rates offered by lenders to be reasonable and competitive compared to other platforms I've used.
    The ability to review lender profiles and read borrower reviews helped me make an informed decision
    before finalizing a loan. The platform's repayment system was also straightforward, allowing me to
    manage my payments conveniently. The only improvement I would suggest is expanding the lender
    network to provide even more options. Nevertheless, Fair Hand Borrowing Company is an excellent
    choice for borrowing and lending needs.`,

    `Fair Hand Borrowing Company is a marketplace that truly lives up to its name.
    The platform emphasizes fairness and transparency in its loan services. I found the interest
    rates offered by lenders to be reasonable and competitive compared to other platforms I've used.
    The ability to review lender profiles and read borrower reviews helped me make an informed decision
    before finalizing a loan. The platform's repayment system was also straightforward, allowing me to manage
    my payments conveniently. The only improvement I would suggest is expanding the lender network to provide
    even more options. Nevertheless, Fair Hand Borrowing Company is an excellent choice for borrowing and lending needs.`,

    `Fair Hand Borrowing Company has proven to be a reliable marketplace for loans and money transfers.
    The platform offers a wide range of loan options and provides detailed information about each lender,
    ensuring transparency throughout the borrowing process. What truly impressed me was the excellent customer
    support. The support team promptly addressed my queries and guided me through the loan
    application. They were courteous, knowledgeable, and went above and beyond to ensure I had a smooth
    experience. The only reason I'm giving four stars instead of five is that the
    interest rates could be slightly more competitive. Nonetheless, Fair Hand Borrowing Company remains a trustworthy choice.`,

    `Fair Hand Borrowing Company is an exceptional marketplace for creating loans and paying other people money.
    The platform provides a seamless experience for both borrowers and lenders. As a borrower,
    I found the process of applying for a loan to be quick and straightforward. The platform's interface is
    user-friendly, and it allowed me to connect with multiple lenders who offered competitive interest rates. Additionally, the
    repayment options were flexible, giving me the freedom to choose a
    plan that suited my financial situation.
    Overall, I highly recommend Fair Hand Borrowing Company for its efficiency and transparency.`,

    `Fair Hand Borrowing Company has proven to be a reliable and trustworthy loan marketplace. I have used their services multiple times,
    and each experience has been exceptional. The platform ensures that borrowers and lenders are matched appropriately, resulting in
    a smooth and efficient loan process. I particularly appreciate the platform's emphasis on responsible lending practices, as it
    gives me confidence in the loans I create or borrow. The customer support team is also highly responsive
    and knowledgeable, always ready to assist with any inquiries. Fair Hand Borrowing Company is my go-to platform for all my loan needs.`,

    `Fair Hand Borrowing Company offers borrowers flexible repayment options, making it convenient to manage loan repayments.
    I was able to choose from various repayment plans that suited my financial situation. The platform's interface provides
    a clear overview of payment schedules, outstanding amounts, and due dates. This transparency helped me stay on top of my repayments without
    any confusion. While the platform is excellent overall, I would suggest introducing more educational resources on financial management to
    assist
    borrowers in making informed decisions. Nonetheless, Fair Hand Borrowing Company is a reliable platform for loans and repayments.`,

    `Fair Hand Borrowing Company offers a seamless loan application process, saving borrowers valuable time and effort. The platform's
    intuitive interface guided me through each step, making the application process quick and straightforward. I appreciated the
    automated document verification, which eliminated the need for extensive paperwork. The platform also provides clear
    instructions and prompts to ensure all required information is provided. Fair Hand Borrowing Company's user-friendly application
    process sets it apart from other loan marketplaces, and I highly recommend it to anyone in need of financial assistance.`,

    `Fair Hand Borrowing Company is a community-driven lending platform that fosters trust and connection
    between borrowers and lenders. The platform's emphasis on borrower reviews and lender profiles allows
    individuals to make informed decisions. I found the community aspect of the platform to be highly beneficial, as it
    created a sense of accountability and transparency. The ability to communicate directly with lenders further enhances the
    overall experience. My only suggestion for improvement would be to expand the platform's community features, such as
    forums or support groups, to facilitate
    more interaction among borrowers and lenders. Nonetheless, Fair Hand Borrowing Company offers a unique and
    empowering lending experience.`

]

let ratings=[
    5,4,3
]

let getRandom=(size)=>{
    return Math.floor(Math.random()*size)
}

async function getPhotoAndReview(numPeople=3){
    let doneAPI=await new Promise((good,bad)=>{
        let url="https://randomuser.me/api/"
        let userObjs=[]

        for(let i=0; i<numPeople; i++){
            fetch(url).then((data)=>{return data.json()}).then((data)=>{
                // need to check if the data comes back
                    // data. status or something??
                if(false){
                    bad("the api failed to get data")
                }

                let newUserObj={
                    sirFix: data.results[0].name.title,
                    name: data.results[0].name.last,
                    email :data.results[0].email,
                    location: data.results[0].location.country,
                    image: data.results[0].picture.large,

                    review:reviews[getRandom(reviews.length)],
                    stars:ratings[getRandom(ratings.length)],
                }
                userObjs.push(newUserObj)

            }).catch((err)=>{console.log(err)})
        }
        good(userObjs)
    })

    console.log(doneAPI)


        // something is wrong here
            // right syntax since it works as a stand alone doc in visualStudio Code
    doneAPI.then(
        (data)=>{
            data.map(onePerson=>{
                placeInHTML(onePerson)
            })
        }
    ).catch((err)=>{console.log("There was an error triggered in testimonials " +err)})

}

let placeInHTML=(data)=>{
    working.innerHTML+=`
    <div class="card">
        <img src=${data.image} >
        <h4>${data.sirFix} ${data.name}</h4>
        <p>${data.review} </p>
        <p>Rating: ${data.stars} /5 </p>
    </div>
    `

    console.log("inside of placeIn HTML")
    console.log(working.innerHTML)
}


getPhotoAndReview();
document.getElementById("testimonials").innerHTML="testimonals has valid fetch code but its not displaying ";
