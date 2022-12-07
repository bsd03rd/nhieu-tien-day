function khovloz(current) {
    let sectionNameModal = document.getElementById("valueEdit");
    let sectionIDModal = document.getElementById("SectionIDModal");
    
    let parentElement = $(current).parent();
    let sectionID = $(parentElement).next();
    let sectionName = $(sectionID).next();

    sectionNameModal.value = sectionName.html();
    sectionIDModal.value = sectionID.html();
}