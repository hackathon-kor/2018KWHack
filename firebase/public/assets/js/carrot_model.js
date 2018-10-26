const carrotModel = {
  account: () => ({
    accountUuid: "",
    name: "",
    phone: "",
    token: "",
    currentPage: ""
  }),
  account: ({ accountUuid, name, phone }) => ({
    accountUuid: accountUuid,
    name: name,
    phone: phone,
    token: "",
    currentPage: ""
  }),

  carrot: () => ({
    accountUuid: "",
    page: 0,
    index: 0,
    status: 0,
    commentType: "",
    comment: "",
    date: ""
  }),
  carrot: ({ accountUuid, page, index }) => ({
    accountUuid: accountUuid,
    page: page,
    index: index,
    status: 0,
    commentType: "",
    comment: "",
    date: ""
  }),

  carrotType: () => ({
    accountUuid: "",
    subject: "",
    imageUrl: "",
    etc: ""
  }),

  carrotType: ({ accountUuid, subject, imageUrl }) => ({
    accountUuid: accountUuid,
    subject: subject,
    imageUrl: imageUrl,
    etc: ""
  }),

  carrotCharacter: () => ({
    accountUuid: "",
    page: 0,
    status: 0
  }),

  carrotCharacter: ({ accountUuid, page }) => ({
    accountUuid: accountUuid,
    page: page,
    status: 0
  })
};
